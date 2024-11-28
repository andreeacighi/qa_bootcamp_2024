import Animal from "./Animal.js";

export default class Fish extends Animal {
  #swimLength;

  constructor(name, age, race) {
    super("fish", name, age, race);
    this.#swimLength = 0;
  }

  swim() {
    this.#swimLength += 10;
  }
}
