package utils;

public enum PageURL {
	LOGIN("/WEB-INF/view/auth/Login.jsp"),
	USER("/WEB-INF/view/auth/User.jsp"),
    DASHBOARD("/WEB-INF/view/admin/dashboard.jsp"),
    REGISTER("/WEB-INF/view/auth/Register.jsp"),
	HOME("/WEB-INF/view/home/home.jsp"),
	PRODUCT_DETAIL("/WEB-INF/view/home/Product_detail.jsp"),
	ABOUT_US("/WEB-INF/view/home/AboutUs.jsp"),
	Order("/WEB-INF/view/admin/Order.jsp");
	

	private final String url;

	private PageURL(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
