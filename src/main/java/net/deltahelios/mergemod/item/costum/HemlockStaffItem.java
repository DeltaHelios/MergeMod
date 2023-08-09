package net.deltahelios.mergemod.item.costum;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.stat.Stats;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;

public class HemlockStaffItem extends SwordItem {

    public HemlockStaffItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1), attacker);
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
