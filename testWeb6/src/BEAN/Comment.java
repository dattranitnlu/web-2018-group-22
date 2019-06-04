package BEAN;

public class Comment {
	private int cmtid;
	private String cmtcontent;
	private String membername;
	private String memberimage;
	private int pageid;

	public Comment() {
		super();
	}

	public int getCmtid() {
		return cmtid;
	}

	public void setCmtid(int cmtid) {
		this.cmtid = cmtid;
	}

	public String getCmtcontent() {
		return cmtcontent;
	}

	public void setCmtcontent(String cmtcontent) {
		this.cmtcontent = cmtcontent;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberimage() {
		return memberimage;
	}

	public void setMemberimage(String memberimage) {
		this.memberimage = memberimage;
	}

	public int getPageid() {
		return pageid;
	}

	public void setPageid(int pageid) {
		this.pageid = pageid;
	}

	

}
