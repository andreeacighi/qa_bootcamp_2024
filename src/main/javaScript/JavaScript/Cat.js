import Animal from "./Animal.js";
import Utils from "./Utils.js";
export default class Cat extends Animal{
    #miceCaught;
    constructor(name,age,race){
        super("cat",name,age,race);
        this.#miceCaught = 0;
    }

    catchMouse(){
        this.#miceCaught = Utils.getIntRandom(0,10);
        console.log(`${this.getName()} has caught ${this.#miceCaught} mouse / mice`);
    }

}