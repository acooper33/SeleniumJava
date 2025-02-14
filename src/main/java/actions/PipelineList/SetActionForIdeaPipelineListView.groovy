package actions.PipelineList;

import actions.PipelineStepsView.ChangeIdeaVisibilityinPipelineStepspage;
import actions.PipelineStepsView.ChangeIdeaCategoryinPipelineStepspage;


class SetActionForIdeaPipelineListView{
    public void run(def params){
        println("We are setting action")
        println(params.Visibility)
        if(params.Visibility!=null){
            println("calling method")
            ChangeIdeaVisibilityinPipelineStepspage.run("Visibility":params.Visibility, "Action":params.Action)
        }
        if(params.Category){
            
        }
        
    }
}