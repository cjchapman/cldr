package org.unicode.cldr.unittest;

import com.ibm.icu.dev.test.TestFmwk;
import java.util.*;
import org.unicode.cldr.util.*;

public class TestVettingViewer extends TestFmwk {

    public void TestNotificationCategories() {
        final Organization org = VettingViewer.getNeutralOrgForSummary();
        final EnumSet<VettingViewer.Choice> set1 = VettingViewer.getPriorityItemsSummaryCategories(org);
        final EnumSet<VettingViewer.Choice> set2 = VettingViewer.getLocaleCompletionCategories();
        if (set1.contains(VettingViewer.Choice.abstained)) {
            errln("getPriorityItemsSummaryCategories should not contain abstained");
        }
        if (!set1.contains(VettingViewer.Choice.warning)) {
            errln("getPriorityItemsSummaryCategories should contain warning");
        }
        if (set2.contains(VettingViewer.Choice.warning)) {
            errln("getLocaleCompletionCategories should not contain warning");
        }
        if (!set1.containsAll(set2)) {
            // This assumption is implicit in the way the Progress column of Priority Items Summary is
            // calculated in the same pass as the other Priority Items Summary columns
            errln("getLocaleCompletionCategories be a subset of getPriorityItemsSummaryCategories");
        }
    }
}
