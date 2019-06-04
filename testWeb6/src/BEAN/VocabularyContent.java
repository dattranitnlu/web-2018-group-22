package BEAN;

public class VocabularyContent {
	private int vocabularycontentid;
	private String vocabularycontentname;
	private String transcribe;
	private String audiomp3;
	private String mean;
	private int vocabularyguidelineid;
	private String vocabularyimage;

	public VocabularyContent() {
		super();
	}

	public int getVocabularycontentid() {
		return vocabularycontentid;
	}

	public void setVocabularycontentid(int vocabularycontentid) {
		this.vocabularycontentid = vocabularycontentid;
	}

	public String getVocabularycontentname() {
		return vocabularycontentname;
	}

	public void setVocabularycontentname(String vocabularycontentname) {
		this.vocabularycontentname = vocabularycontentname;
	}

	public String getTranscribe() {
		return transcribe;
	}

	public void setTranscribe(String transcribe) {
		this.transcribe = transcribe;
	}

	public String getAudiomp3() {
		return audiomp3;
	}

	public void setAudiomp3(String audiomp3) {
		this.audiomp3 = audiomp3;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	public int getVocabularyguidelineid() {
		return vocabularyguidelineid;
	}

	public void setVocabularyguidelineid(int vocabularyguidelineid) {
		this.vocabularyguidelineid = vocabularyguidelineid;
	}

	public String getVocabularyimage() {
		return vocabularyimage;
	}

	public void setVocabularyimage(String vocabularyimage) {
		this.vocabularyimage = vocabularyimage;
	}

}
