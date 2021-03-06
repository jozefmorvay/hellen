/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors;

import java.util.ArrayList;
import java.util.List;
import sk.tuke.oop.framework.Actor;
import sk.tuke.oop.framework.Animation;
import sk.tuke.oop.framework.Input;
import sk.tuke.oop.framework.World;

/**
 *
 * @author admin
 */
public abstract class AbstractActor implements Actor {
    
    int x;
    int y;
    int height;
    int width;
    private int step;
    String name;
    private String type;
    public Animation normalAnimation;
    private Input input;
    private World world;
    List intersectingActors = new ArrayList<>();

    public AbstractActor() {
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setPosition(int i, int i1) {
        this.x = i;
        this.y = i1;
    }

    @Override
    public Animation getAnimation() {
        return this.normalAnimation;
    }

    @Override
    public void setAnimation(Animation anmtn) {
        this.normalAnimation = anmtn;
        this.height = anmtn.getHeight();
        this.width = anmtn.getWidth();
    }

    @Override
    public void act() {
    }

    @Override
    public boolean intersects(Actor actor) {
        return (this.getY() + this.getHeight() < actor.getY() == false && 
                this.getY() > actor.getY() + actor.getHeight() == false &&
                this.getX() + this.getWidth() < actor.getX() == false &&
                this.getX() > actor.getX() + actor.getWidth() == false);
    
    }

    @Override
    public void addedToWorld(World world) {
        this.setWorld(world);
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }    
    
    public String toString()
    {
        return this.name + " " + this.getX() + " " + this.getY() + " " + this.getAnimation().getRotation();
    }
    
    public List getIntersectingActors()
    {
        
        
        for(Actor actor : getWorld())
        {
            if(this.intersects(actor))
                intersectingActors.add(actor);
        }
        
        return intersectingActors;
    }
    
    public Actor getActorByName(String name)
    {

        if(getName().equals(name))
        {
            return this;
        } else {
            return null;
        }

    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the step
     */
    public int getStep() {
        return step;
    }

    /**
     * @param step the step to set
     */
    public void setStep(int step) {
        this.step = step;
    }

    public int calculateX(Actor actor, boolean edge){
        int actorX = 0;
        if(edge){
            if(getAnimation().getRotation() == 0)
            {
                actorX = (getX() + getWidth()/2) - actor.getWidth()/2;
            }
            if(getAnimation().getRotation() == 45)
            {
                actorX = getX() + getWidth();
            }
            if(getAnimation().getRotation() == 90)
            {
                actorX = getX() + getWidth();
            }
            if(getAnimation().getRotation() == 135)
            {
                actorX = getX() + getWidth();
            }    
            if(getAnimation().getRotation() == 180)
            {
                actorX = (getX() + getWidth()/2) - actor.getWidth()/2;
            }  
            if(getAnimation().getRotation() == 225)
            {
                actorX = getX() - actor.getWidth();
            }    
            if(getAnimation().getRotation() == 270)
            {
                actorX = getX() - actor.getWidth();
            } 
            if(getAnimation().getRotation() == 315)
            {
                actorX = getX() - actor.getWidth();
            }
        } else {
            if(getAnimation().getRotation() == 0)
            {
                actorX = (getX() + getWidth()/2) - actor.getWidth()/2;
            }
            if(getAnimation().getRotation() == 45)
            {
                actorX = getX() + actor.getWidth();
            }
            if(getAnimation().getRotation() == 90)
            {
                actorX = getX() + actor.getWidth();
            }
            if(getAnimation().getRotation() == 135)
            {
                actorX = getX() + actor.getWidth();
            }    
            if(getAnimation().getRotation() == 180)
            {
                actorX = (getX() + getWidth()/2) - actor.getWidth()/2;
            }  
            if(getAnimation().getRotation() == 225)
            {
                actorX = getX();
            }    
            if(getAnimation().getRotation() == 270)
            {
                actorX = getX();
            } 
            if(getAnimation().getRotation() == 315)
            {
                actorX = getX();
            }            
        }
            return actorX;
    }    
    
    public int calculateY(Actor actor, boolean edge){   
        int actorY = 0;
        if(edge){
            if(getAnimation().getRotation() == 0)
            {
                actorY = getY() - actor.getHeight();
            }
            if(getAnimation().getRotation() == 45)
            {
                actorY = getY() - actor.getHeight();
            }
            if(getAnimation().getRotation() == 90)
            {
                actorY = (getY() + getHeight()/2) - actor.getHeight()/2;
            }
            if(getAnimation().getRotation() == 135)
            {
                actorY = getY() + getHeight();
            }    
            if(getAnimation().getRotation() == 180)
            {
                actorY = getY() + getHeight();
            }  
            if(getAnimation().getRotation() == 225)
            {
                actorY = getY() + getHeight();
            }    
            if(getAnimation().getRotation() == 270)
            {
                actorY = (getY() + getHeight()/2) - actor.getHeight()/2;
            } 
            if(getAnimation().getRotation() == 315)
            {
                actorY = getY() - actor.getHeight();
            }
        } else {
            if(getAnimation().getRotation() == 0)
            {
                actorY = getY();
            }
            if(getAnimation().getRotation() == 45)
            {
                actorY = getY();
            }
            if(getAnimation().getRotation() == 90)
            {
                actorY = (getY() + getHeight()/2) - actor.getHeight()/2;
            }
            if(getAnimation().getRotation() == 135)
            {
                actorY = getY() + actor.getHeight();
            }    
            if(getAnimation().getRotation() == 180)
            {
                actorY = getY() + actor.getHeight();
            }  
            if(getAnimation().getRotation() == 225)
            {
                actorY = getY() + actor.getHeight();
            }    
            if(getAnimation().getRotation() == 270)
            {
                actorY = getY() + actor.getHeight();
            } 
            if(getAnimation().getRotation() == 315)
            {
                actorY = getY();
            }            
        }
            return actorY;
            
    }  
    
}
