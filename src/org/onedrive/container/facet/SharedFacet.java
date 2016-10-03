package org.onedrive.container.facet;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import org.json.simple.JSONObject;
import org.onedrive.container.IdentitySet;

/**
 * https://dev.onedrive.com/facets/shared_facet.htm
 * TODO: Enhance javadoc
 * Created by isac322 on 16. 10. 3.
 *
 * @author isac322
 */
public class SharedFacet {
	@Getter protected final IdentitySet owner;
	@Getter protected final String scope;

	protected SharedFacet(IdentitySet owner, String scope) {
		this.owner = owner;
		this.scope = scope;
	}

	@Nullable
	public static SharedFacet parse(JSONObject json) {
		if (json == null) return null;

		return new SharedFacet(
				IdentitySet.parse(json.getObject("owner")),
				json.getString("scope"));
	}
}
