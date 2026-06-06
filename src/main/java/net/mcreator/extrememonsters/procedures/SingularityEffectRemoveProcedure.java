package net.mcreator.extrememonsters.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.mcreator.extrememonsters.init.ExtremeMonstersModMobEffects;

/**
 * Removes only HARMFUL effects from a living entity.
 * Does not reference MobEffect class at compile time (reflection-only),
 * so it avoids "cannot find symbol: MobEffect" compilation errors in different mappings.
 *
 * Note: reflection is slower. Replace with direct API calls when your mappings allow it.
 */
public class SingularityEffectRemoveProcedure {
    public static void execute(Entity entity) {
        if (entity == null) return;
        if (!(entity instanceof LivingEntity livingEntity)) return;

        // 복사해서 반복 (동시 수정 방지)
        List<MobEffectInstance> active = new ArrayList<>(livingEntity.getActiveEffects());

        for (Object instObj : active) { // MobEffectInstance at runtime
            try {
                // 1) getEffect() 호출 (reflection)
                Object effectObj = null;
                try {
                    Method mGetEffect = instObj.getClass().getMethod("getEffect");
                    effectObj = mGetEffect.invoke(instObj);
                } catch (NoSuchMethodException e) {
                    // 일부 매핑에서는 다른 이름일 수 있으니 시도해볼 수 있는 이름들 추가 가능
                    try {
                        Method mAlt = instObj.getClass().getMethod("getEffectType");
                        effectObj = mAlt.invoke(instObj);
                    } catch (NoSuchMethodException ex) {
                        // 못 찾으면 다음 인스턴스로
                        continue;
                    }
                }

                if (effectObj == null) continue;

                // 2) effect.getCategory() 호출 (reflection)
                Object categoryObj = null;
                try {
                    Method mGetCategory = effectObj.getClass().getMethod("getCategory");
                    categoryObj = mGetCategory.invoke(effectObj);
                } catch (NoSuchMethodException e) {
                    // 일부 매핑 차이 처리: 메서드가 없으면 건너뜀
                    continue;
                }

                // 3) HARMFUL인지 판정 (MobEffectCategory는 컴파일 타임에 존재함)
                if (MobEffectCategory.HARMFUL.equals(categoryObj)) {
                    // 4) livingEntity.removeEffect(effect) 를 reflection으로 호출 (컴파일 의존성 회피)
                    boolean removed = false;
                    try {
                        Method mRemove = livingEntity.getClass().getMethod("removeEffect", effectObj.getClass());
                        mRemove.invoke(livingEntity, effectObj);
                        removed = true;
                    } catch (NoSuchMethodException ns) {
                        // 정확한 파라미터 타입을 못찾을 경우, 이름이 "removeEffect"인 1-파라미터 메서드를 찾아 시도
                        for (Method m : livingEntity.getClass().getMethods()) {
                            if (!m.getName().equals("removeEffect")) continue;
                            if (m.getParameterCount() != 1) continue;
                            try {
                                m.invoke(livingEntity, effectObj);
                                removed = true;
                                break;
                            } catch (Throwable ignore) {
                                // 시도 실패하면 다음 메서드로
                            }
                        }
                    } catch (Throwable t) {
                        // invoke 실패 시 무시하고 다음으로
                    }

                    // 만약 위의 모든 시도가 실패했으면, 대체로 효과 제거를 포기(크래시 방지)
                    if (!removed) {
                        // (선택) 로깅을 추가하고 싶다면 여기에 로그 코드 삽입
                    }
                }
            } catch (Throwable t) {
                // 절대 틱 루프에서 throw 되게 하지 말 것 — 안정성 최우선
            }
        }
    }
}