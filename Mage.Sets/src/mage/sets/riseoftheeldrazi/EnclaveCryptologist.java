/*
 *  Copyright 2011 BetaSteward_at_googlemail.com. All rights reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 * 
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 * 
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 * 
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */

package mage.sets.riseoftheeldrazi;

import mage.constants.CardType;
import mage.constants.Rarity;
import mage.constants.Zone;
import mage.MageInt;
import mage.abilities.Abilities;
import mage.abilities.AbilitiesImpl;
import mage.abilities.Ability;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.costs.mana.ManaCostsImpl;
import mage.abilities.effects.common.DrawCardSourceControllerEffect;
import mage.abilities.effects.common.DrawDiscardControllerEffect;
import mage.abilities.keyword.LevelerCardBuilder;
import mage.abilities.keyword.LevelUpAbility;
import mage.cards.LevelerCard;

import java.util.UUID;

/**
 *
 * @author BetaSteward_at_googlemail.com, noxx
 */
public class EnclaveCryptologist extends LevelerCard {

    public EnclaveCryptologist (UUID ownerId) {
        super(ownerId, 66, "Enclave Cryptologist", Rarity.UNCOMMON, new CardType[]{CardType.CREATURE}, "{U}");
        this.expansionSetCode = "ROE";
        this.subtype.add("Merfolk");
        this.subtype.add("Wizard");
        this.color.setBlue(true);
        this.power = new MageInt(0);
        this.toughness = new MageInt(1);

        this.addAbility(new LevelUpAbility(new ManaCostsImpl("{1}{U}")));

        Ability ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new DrawDiscardControllerEffect(), new TapSourceCost());
        Abilities<Ability> abilities1 = new AbilitiesImpl<Ability>(ability);

        ability = new SimpleActivatedAbility(Zone.BATTLEFIELD, new DrawCardSourceControllerEffect(1), new TapSourceCost());
        Abilities<Ability> abilities2 = new AbilitiesImpl<Ability>(ability);

        this.addAbilities(LevelerCardBuilder.construct(
                new LevelerCardBuilder.LevelAbility(1, 2, abilities1, 0, 1),
                new LevelerCardBuilder.LevelAbility(3, -1, abilities2, 0, 1)
        ));
        setMaxLevelCounters(3);
    }

    public EnclaveCryptologist (final EnclaveCryptologist card) {
        super(card);
    }

    @Override
    public EnclaveCryptologist copy() {
        return new EnclaveCryptologist(this);
    }

}
