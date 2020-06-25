/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entity.CombatableEntity;
import Entity.Entity;

/**
 *
 * @author Administrator
 */

//攻击个体实体接口
public interface AttackSingle 
{
  public int AttackSingle(CombatableEntity A,CombatableEntity B);
  
  
}
