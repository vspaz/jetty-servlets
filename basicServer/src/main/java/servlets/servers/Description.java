package servlets.servers;

import java.util.ArrayList;

class Description {
    private int id;
    private String name;
    private String description;
    private int ram;
    private int cpu;
    private long hdd;

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    private ArrayList<String> tags;

    public Description() {

    }

    public static Description CreateDescription() {
        return new Description();
    }

    private Description(int id, String name, String description, int ram, int cpu, long hdd, ArrayList<String> tags) {
        setId(id);
        setName(name);
        setDescription(description);
        setRam(ram);
        setCpuCount(cpu);
        setHdd(hdd);
        setTags(tags);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRam() {
        return ram;
    }

    public int getCpu() {
        return cpu;
    }

    public long getHdd() {
        return hdd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setCpuCount(int cpu) {
        this.cpu = cpu;
    }

    public void setHdd(long hdd) {
        this.hdd = hdd;
    }
}
