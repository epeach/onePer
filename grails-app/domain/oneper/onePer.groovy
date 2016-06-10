package oneper

import metafunctionality.ModuleInput

class onePer extends ModuleInput {
    Double seconds
    Boolean oneAtTime
    static hasMany = [words:String]
    List words
}