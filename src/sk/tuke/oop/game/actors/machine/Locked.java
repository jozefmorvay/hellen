/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.oop.game.actors.machine;

/**
 *
 * @author jmorvay
 */
public class Locked extends AbstractMachineState{
    
public AbstractMachineState wallSwitchActivated(){
    return new Running();
}
    
}
