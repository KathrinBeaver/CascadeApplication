package controllers.TestComEditPages.GlasialEditPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.TestCom.GlasialEditModel;

public class DelJudge implements ActionListener {
    GlasialEditModel glasialEditModel;
    public void actionPerformed(ActionEvent e) {
        glasialEditModel = GlasialEditModel.getGlasialEditModelInstance();
        glasialEditModel.delJudge();
    }   
}
