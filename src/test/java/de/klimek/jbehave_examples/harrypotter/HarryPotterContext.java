package de.klimek.jbehave_examples.harrypotter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.klimek.jbehave_examples.harrypotter.LivingCreature;
import de.klimek.jbehave_examples.harrypotter.Wizard;

public class HarryPotterContext {

	public static final String TARGET = "target";
	public static final String WIZARD = "wizard";
	private Map<String, LivingCreature> entities = new HashMap<>();

	public void addTarget(LivingCreature target) {
		entities.put(TARGET, target);
	}

	public LivingCreature getTarget() {
		return entities.get(TARGET);
	}

	public void addWizard(Wizard wizard) {
		entities.put(WIZARD, wizard);
	}

	public Wizard getWizard() {
		return (Wizard) entities.get(WIZARD);
	}

	public static boolean isTarget(String query) {
		return query.toLowerCase().contains(HarryPotterContext.TARGET);
	}

	public static boolean isWizard(String query) {
		return query.toLowerCase().contains(HarryPotterContext.WIZARD);
	}

	public static boolean isAnySpell(String spell) {
		return spell.toLowerCase().contains("any");
	}

	public LivingCreature getEntityByName(String name) {
		if (isTarget(name)) {
			return getTarget();
		} else if (isWizard(name)) {
			return getWizard();
		} else {
			// check by name
			for (Entry<String, LivingCreature> entry : entities.entrySet()) {
				LivingCreature entity = entry.getValue();
				if (entity.getName().equals(name)) {
					return entity;
				}
			}
		}

		throw new IllegalArgumentException("Unknown entity");
	}

	public void reset() {
		entities.clear();
	}

}