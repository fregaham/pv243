package cz.muni.fi.pv243.lesson03.viewconfig;

import org.jboss.seam.faces.event.PhaseIdType;
import org.jboss.seam.faces.rewrite.UrlMapping;
import org.jboss.seam.faces.security.AccessDeniedView;
import org.jboss.seam.faces.security.LoginView;
import org.jboss.seam.faces.security.RestrictAtPhase;
import org.jboss.seam.faces.view.config.ViewConfig;
import org.jboss.seam.faces.view.config.ViewPattern;
import org.jboss.seam.security.annotations.LoggedIn;

@ViewConfig
public interface Pages {
	static enum Pages1 {
		@ViewPattern("/view.xhtml")
		@UrlMapping(pattern="/view/#{id}/")
        VIEW,
        
        @ViewPattern("/edit.xhtml")
        EDIT,
        
        @ViewPattern("/bakerylist.xhtml")
        BAKERYLIST,
        
        @ViewPattern("/managers.xhtml")
		@LoginView("/login.xhtml")
        @AccessDeniedView("/denied.xhtml")
		@LoggedIn
		@RestrictAtPhase({PhaseIdType.RESTORE_VIEW, PhaseIdType.INVOKE_APPLICATION})
		MANAGERS
    }
}
