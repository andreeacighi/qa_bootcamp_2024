import Utils from "./Utils.js";

export default class Animal {
  // Private
  #age;
  #name;
  #race;
  #type;
  #color;
  #price;

  constructor(type, name, age, race) {
    this.#type = type;
    this.#age = age;
    this.#name = name;
    this.#race = race;
    this.#price = Utils.getIntRandom(100,1000);
  }

  printAnimal() {
    console.log(
      `My ${this.#type} is called ${this.#name} and has ${
        this.#age
      } years. It is  ${this.#race}`
    );
  }
  get color() {
    return this.#color;
  }

  setPrice(price){
    this.price = price;
  }
  getPrice(){
    return this.#price;
  }
  getName() {
    return this.#name;
  }
  set color(color) {
    this.#color = color;
  }
}
