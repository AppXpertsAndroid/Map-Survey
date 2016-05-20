package au.appxperts.ga.mapsurvey.requestresponse;

/**
 * Created by xpertsinfosoftmac-3 on 20/05/16.
 */
import java.util.ArrayList;
import java.util.List;




public class Bundles {


    private List<GABundle> bundles = new ArrayList<GABundle>();

    /**
     *
     * @return
     * The bundles
     */
    public List<GABundle> getBundles() {
        return bundles;
    }

    /**
     *
     * @param bundles
     * The bundles
     */
    public void setBundles(List<GABundle> bundles) {
        this.bundles = bundles;
    }

}