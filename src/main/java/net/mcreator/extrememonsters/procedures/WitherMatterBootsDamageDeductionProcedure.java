//package net.mcreator.extrememonsters.procedures;
//
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.event.entity.living.LivingHurtEvent;
//
//import net.minecraft.world.entity.LivingEntity;
//import net.minecraft.world.entity.EquipmentSlot;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.entity.Entity;
//
//import net.mcreator.extrememonsters.init.ExtremeMonstersModItems;
//
//@Mod.EventBusSubscriber
//public class WitherMatterBootsDamageDeductionProcedure {
//    @SubscribeEvent
//    public static void onEntityHurt(LivingHurtEvent event) {
//        execute(event);
//    }
//
//    public static void execute(LivingHurtEvent event) {
//        Entity entity = event.getEntity();
//        if (!(entity instanceof LivingEntity living)) return;
//
//        ItemStack boots = living.getItemBySlot(EquipmentSlot.FEET);
//
//        if (boots.getItem() == ExtremeMonstersModItems.WITHER_MATTER_ARMOR_BOOTS.get()) {
//            float originalDamage = event.getAmount();
//            event.setAmount(originalDamage * 0.7f);
//        }
//    }
//}
