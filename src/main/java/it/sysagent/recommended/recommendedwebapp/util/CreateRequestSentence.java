package it.sysagent.recommended.recommendedwebapp.util;

import it.sysagent.recommended.recommendedwebapp.dto.RequestSentence;

public class CreateRequestSentence {

    public static RequestSentence create(String comment){
        RequestSentence req = new RequestSentence();
        req.setSentence(comment);
        req.setModel_path("model_saved/model");
        req.setDataset_path("");
        return req;
    }
}
