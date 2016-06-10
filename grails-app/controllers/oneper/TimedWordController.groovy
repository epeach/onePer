package oneper

import oneper.onePer
import metafunctionality.Module
import metafunctionality.ModuleOutput

class TimedWordController {

    def index() {
        render(view:"start.gsp")
    }

    def home() {
        render(view:"start.gsp")
    }

    def start() {
        String inputID = Module.findByModuleId(params.id).inputID
        onePer input = onePer.findByModuleDataID(inputID)
        List<String> words = input.words
        Boolean one = input.oneAtTime
        Double seconds = input.seconds
        //Store Module in saveModuleService
        [words:words, one:one, seconds:seconds, modID:params.id]
    }

    def submit(){
        List valueRows = new ArrayList<String>()
        ModuleOutput output = new ModuleOutput()
        output.headers = ["onePer"]

        String inputID = Module.findByModuleId(params.modID).inputID
        onePer input = onePer.findByModuleDataID(inputID)

        String valueRow = input.oneAtTime

        valueRows.add(valueRow)
        output.valueRows = valueRows
        Module m = Module.findByModuleId(params.modID)
        if (m.outputIDs != null) {
            m.outputIDs.add(output.moduleDataID)
        } else {
            m.outputIDs = [output.moduleDataID]
        }
        output.type = "FirstExample"
        m.isCompleted = true
        m.save(flush: true)
        output.save(flush: true)
        render(view: "submit")
    }
}
