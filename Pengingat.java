class Pengingat {
    private String id;
    private String pesan;

    public Pengingat(String id, String pesan) {
        this.id = id;
        this.pesan = pesan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}