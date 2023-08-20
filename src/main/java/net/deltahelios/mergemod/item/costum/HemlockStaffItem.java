package net.deltahelios.mergemod.item.costum;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;

public class HemlockStaffItem extends SwordItem {

    public HemlockStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 150, 1), attacker);
        return super.postHit(stack, target, attacker);
    }
    @Override
    public boolean isEnchantable(ItemStack stack){
        return false;
    }
    @Override
    public Rarity getRarity(ItemStack stack) {

        return Rarity.UNCOMMON;
    }


}
