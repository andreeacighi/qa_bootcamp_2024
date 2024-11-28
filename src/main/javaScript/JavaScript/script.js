function test() {
  console.log("Start of the script");
  var x = 100;
  console.log(x);
  let myValue = x + x / 2;
  let isOdd = x % 2 == 0;
  console.log(typeof isOdd);
  console.log(typeof myValue);
  let myNumber = 2e3;
  console.log(typeof myNumber);
  let variabile1 = "ana";
  let variabile2 = "are mere";
  console.log(variabile1 + "" + variabile2);
  let y = "2";
  console.log(x + y);
  const Y = true;
  const T = false;
  console.log((T && (Y || T)) || Y);
}
const add = function (a = 100, b = 200) {
  // functie anonima
  console.log(arguments);
  return a + b;
}; // stocheaza functia intr-o variabila pe care poti sa o apelezi
console.log(add(500));
//console.log(add);
// abreviere a functiei de sus
const arrowAdd = (a, b) => a + b; //preferat de programatori

const arrowSubtract = (a, b) => a - b;
console.log(arrowAdd(500, 600));
console.log(typeof arrowAdd);

function evaluate(x, y, f) {
  return f(x, y);
}
console.log(evaluate(100, 200, arrowAdd));

console.log(evaluate(100, 200, arrowSubtract));

const arrayFunc = () => {
  const myFunc = (a, b, c) => a + b * c;
  let myArr = [1, 2, 3];
  let mixArr = [6, "Ana are mere", myArr, myFunc];
  return mixArr;
};
function arrayStuff() {
  console.log(arrayFunc()[3](1, 5, 7));
  console.log(arrayFunc()[2][1]);

  const myArray = [];
  myArray.push("ana");
  myArray.push("andrei");
  myArray.push("andreea");
  console.log(myArray);
  console.log(myArray.pop());
  console.log(myArray);
  myArray.unshift("gabriel");
  myArray.unshift("daniela");
  console.log(myArray.shift());
  console.log(myArray);

  console.log("While");
  let i = 0;
  while (i < myArray.length) {
    console.log(myArray[i]);
    i++;
  }

  console.log("Do - while");
  let j = 0;
  do {
    console.log(myArray[j]);
    j++;
  } while (j < myArray.length);

  console.log("For:");
  for (let i = 0; i < myArray.length; i++) {
    console.log(myArray[i]);
  }
  console.log("Foreach"); // cea mai simpla
  for (const val of myArray) {
    console.log(val);
  }
}

const animal1 = {
  type: "dog",
  name: "toby",
  age: 5,
  race: "labrador",
  eat: function () {
    console.log(
      `My ${this.type} is called ${this.name} and has ${this.age} years. He is a ${this.race} that is well fed now`
    );
  },
};
animal1.eat();

const a1 = new Animal("dog", "toby", 5, "labrador");
console.log(a1);
a1.printAnimal();
console.log(a1.name);
console.log(a1.type);
console.log(a1.getName()); //apelezi getterul
a1.color = "Brown"; //apelezi setterul de color

const d1 = new Dog("Sophie", 5, "labrador");
console.log(d1);
d1.printAnimal();
