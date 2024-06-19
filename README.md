# Vikings 2.0

In this exercise, you will apply object-oriented programming and inheritance concepts with Java to our Viking friends.

## Requirements
- You will be assigned a repository from Classroom.

## Submission
1. Fork the repository to your local environment.
2. Tests, tests, tests!
3. Have JUnit up and running.
4. Execute all tests.
5. Uncomment the tests one by one and continue coding to pass the tests.
6. Continue doing the same with the test files: Viking, Saxon, and War.

## Exercise

### Soldier
Modify the `Soldier` class and add two methods `attack()` and `receiveDamage()`.

#### Constructor Method
- Should receive 2 arguments (health & strength)
- Should set the health property as the 1st argument
- Should set the strength property as the 2nd argument

#### attack() Method
- Should be a function
- Should receive 0 arguments
- Should return the strength property of the Soldier

#### receiveDamage() Method
- Should be a function
- Should receive 1 argument (damage)
- Should subtract the received damage from the health property
- Should not return anything

### Viking
A Viking is a Soldier with an additional property, their name. Also, the `receiveDamage()` method is implemented differently and it has a new method: `battleCry()`.

Modify the Viking class constructor to inherit from the Soldier class, reimplement the `receiveDamage()` method inside the Viking class, and add the new method `battleCry()`.

#### Inheritance
- Viking should extend the Soldier class

#### Constructor Method
- Should receive 3 arguments (name, health & strength)
- Should set the name property as the 1st argument
- Should set the health property as the 2nd argument
- Should set the strength property as the 3rd argument

#### attack() Method
- Inherited from Soldier, no need to reimplement.
- Should be a function
- Should receive 0 arguments
- Should return the strength property of the Viking

#### receiveDamage() Method
- Needs reimplementation for Viking as the Viking version returns different values.
- Should be a function
- Should receive 1 argument (damage)
- Should subtract the received damage from the health property
- Should not return anything
- If the Viking is still alive, should set the message to "NAME has received DAMAGE points of damage"
- If the Viking dies, should set the message to "NAME has died in act of combat"

#### battleCry() Method
- Should be a function
- Should receive 0 arguments
- Should return "Odin Owns You All!"

### Saxon
A Saxon is a weaker version of a Soldier. Unlike a Viking, the Saxon has no name. Their `receiveDamage()` method is also different from the Soldier version.

Modify the Saxon constructor to extend Soldier and reimplement the `receiveDamage()` method.

#### Inheritance
- Saxon should extend the Soldier class

#### Constructor Method
- Should receive 2 arguments (health & strength)
- Should set the health property as the 1st argument
- Should set the strength property as the 2nd argument

#### attack() Method
- Inherited from Soldier, no need to reimplement.
- Should be a function
- Should receive 0 arguments
- Should return the strength property of the Soldier

#### receiveDamage() Method
- Needs reimplementation for Saxon as the Saxon version returns different values.
- Should be a function
- Should receive 1 argument (damage)
- Should subtract the received damage from the health property
- If the Saxon is still alive, should set the message to "A Saxon has received DAMAGE points of damage"
- If the Saxon dies, should set the message to "A Saxon has died in combat"

### (BONUS) War
Now let's get into the thick of it: WAR. The War class should facilitate a battle between the Viking army and the Saxon army.

Modify the War class and add these 5 methods:
- `addViking()`
- `addSaxon()`
- `vikingAttack()`
- `saxonAttack()`
- `showStatus()`

#### Constructor Method
- When War is created, both armies should be empty. Soldiers will be added to the armies later.
- Should receive 0 arguments
- Should assign an empty array (List) to the `vikingArmy` property
- Should assign an empty array (List) to the `saxonArmy` property

#### addViking() Method
- Adds 1 Viking to the `vikingArmy`. If you want an army of 10 Vikings, you will need to call the method 10 times.
- Should be a function
- Should receive 1 argument (a Viking object)
- Should add the received Viking to the army
- Should not return anything

#### addSaxon() Method
- The Saxon version of `addViking()`.
- Should be a function
- Should receive 1 argument (a Saxon object)
- Should add the received Saxon to the army
- Should not return anything

#### vikingAttack() Method
- Invokes the `receiveDamage()` method of a randomly chosen Saxon with damage equal to the strength of a randomly chosen Viking. Only one attack is performed, and the Saxon does not counterattack.
- Should be a function
- Should receive 0 arguments
- Should make `receiveDamage()` of Saxon equal to the strength of a Viking
- Should remove dead Saxons from the army
- Should return the result of calling `receiveDamage()` of Saxon with the strength of Viking

#### saxonAttack() Method
- The Saxon version of `vikingAttack()`. A Viking receives damage equal to the strength of a Saxon.
- Should be a function
- Should receive 0 arguments
- Should make `receiveDamage()` of Viking equal to the strength of a Saxon
- Should remove dead Vikings from the army
- Should return the result of calling `receiveDamage()` of Viking with the strength of Saxon

#### showStatus() Method
- Returns the current state of the War based on the size of the armies.
- Should be a function
- Should receive 0 arguments
- If the Saxon array is empty, return "Vikings have won the war of the century!"
- If the Viking array is empty, return "Saxons have fought for their lives and survive another day..."
- If there is at least 1 Viking and 1 Saxon, return "Vikings and Saxons are still in the thick of battle."