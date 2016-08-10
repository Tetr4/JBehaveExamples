Story: Avada Kedavra in action

Narrative:
In order to understand one of the three Unforgivable Curses.
As a wizard
I want to see the Avada Kedavra in action

Scenario: Nobody except Harry or Lord Voldemort can survive to the spell
Given a wizard named Lord Voldemort
And a target named Lily Potter
When the wizard cast the spell Avada Kedavra
Then the target is dead

Scenario: Harry can survive to the spell
Given a wizard named Lord Voldemort
And a target named Harry Potter blessed with the sacrificial protection
When the wizard cast the spell Avada Kedavra
Then the target is alive

Scenario: Lord Voldemort can survive to his own curse backfired
Given a wizard named Lord Voldemort
And Lord Voldemort has 7 horcruxes
And a target that counterspells any spells
When the wizard cast the spell Avada Kedavra
Then the target is alive

Scenario: Lord Voldemort cannot survive without horcruxe
Given a wizard named Lord Voldemort
And Lord Voldemort has 0 horcrux
And a target named Lord Voldemort
When the wizard cast the spell Avada Kedavra
Then the target is dead