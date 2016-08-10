package de.klimek.jbehave_examples.harrypotter;

public class Spell {
    private String name;

    public Spell(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Spell))
            return false;
        Spell other = (Spell) obj;
        return name.equals(other.name);
    }
    
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
