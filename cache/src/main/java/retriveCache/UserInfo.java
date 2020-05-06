package retriveCache;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

public class UserInfo extends JSONObject {

	public UserInfo() {

		setUserDetail(new UserDetails());
	}

	public UserInfo(JSONObject symbolobj) {
		this.put("USER_INFO", new UserDetails(symbolobj));
	}

	public void setUserDetail(UserDetails symBlock) {
		this.put("USER_INFO", new UserDetails(symBlock));
	}

	public void extend(UserInfo otherRow) {
		String[] fields = JSONObject.getNames(otherRow);
		for (String f : fields) {
			this.put(f, otherRow.get(f));
		}

	}

	public void extend(JSONObject jsonObject) {

		String[] fields = JSONObject.getNames(jsonObject);
		for (String f : fields) {
			this.put(f, jsonObject.get(f));
		}
	}

	public UserInfo(ResultSet rs) throws JSONException, SQLException {
		this.put("USER_INFO", new UserDetails());
		this.setName(rs.getString("NAME"));
		this.setID(rs.getString("ID"));
		this.setDesignation(rs.getString("DESIGNATION"));

	}

	public UserInfo(Object object) {
		String[] fields = JSONObject.getNames(object);
		for (String f : fields) {
			this.put(f, ((JSONObject) object).get(f));
		}
	}

	@Override
	public JSONObject put(String key, Object value) throws JSONException {
		return super.put(key, value);
	}

	public void setName(String name) {
		this.getSymBlock().put("NAME", name);
	}

	public String getName() {
		return this.getSymBlock().getString("NAME");
	}

	public void setID(String id) {
		this.getSymBlock().put("ID", id);
	}

	public String getID() {
		return this.getSymBlock().getString("ID");
	}

	public void setDesignation(String designation) {
		this.getSymBlock().put("DESIGNATION", designation);
	}

	public String getDesignation() {
		return this.getSymBlock().getString("DESIGNATION");
	}

	public JSONObject getSymBlock() {
		return this.getJSONObject("USER_INFO");
	}

}