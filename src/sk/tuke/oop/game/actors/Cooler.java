/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.game.items.Hammer;
import sk.tuke.oop.game.items.Wrench;

/**
 *
 * @author admin
 */
public class Cooler extends AbstractActor implements Repairable{
    private boolean broken;

    
    public Cooler()
    {
        normalAnimation = new Animation("resources/sprites/fan.png",32,32,200);
        setAnimation(normalAnimation);
        normalAnimation.stop();
        broken = true;
    }
    
    public boolean isBroken()
    {
        return broken;
    }

    @Override
    public void repair(Actor actor) {
        if(actor instanceof Hammer)
        {
        this.broken = false;
        normalAnimation.start();
        }
    }
    
}
