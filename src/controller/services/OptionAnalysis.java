package controller.services;

import view.UserInterface;

public class OptionAnalysis implements AnalysisOption{
    @Override
    public int analysis(String option) {
        try{
            return Integer.parseInt(option);
        }catch(Exception e){
            UserInterface.getInstance().displayMessage("Not an option.");
        }
        return -1;
    }
}
