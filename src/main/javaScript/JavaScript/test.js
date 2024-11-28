import Animal from './Animal.js';
import Dog from './Dog.js';
import Cat from './Cat.js';
import Fish from './Fish.js';


const a1 = new Animal("cat","Garfield",2,"unknown");
const d1 = new Dog("Maya",3,"Little");
const c1 = new Cat("Luna",2,"British");
console.log(a1.getName());

const f1 = new Fish("Nemo",1,"Clown");
f1.swim();

const petStore = [a1, d1, c1, f1];
console.log(`My petSotre has ${petStore.length} animals: `);
let priceValue = 0;
for (const animal of petStore){
    animal.printAnimal();
    priceValue += animal.getPrice();
}

console.log(`My petstore animals are worth ${priceValue}`);


