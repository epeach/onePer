package oneper

import metafunctionality.ModuleInput

class onePer extends ModuleInput {
    Double seconds
    static hasMany = [words:String]
    List words
}