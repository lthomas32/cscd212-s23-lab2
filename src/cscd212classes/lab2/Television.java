package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable<Television> {
    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {
        if (model == null || model.isBlank() || make == null || make.isBlank()|| screenSize < 32 || resolution < 720)
            throw new IllegalArgumentException("Invalid parameter in constructor");
        this.make = make;
        this.model = model;
        this.resolution = resolution;
        this.screenSize = screenSize;
        this.smart = smart;
        this.fourK = resolution == 2160;
    }

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution){
        this(model, smart,screenSize,resolution,make);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Television that)) return false;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return this.make.hashCode() + Boolean.hashCode(this.fourK) + this.model.hashCode() + this.resolution +Boolean.hashCode(this.smart);
    }

    @Override
    public String toString() {
        return this.make + "-" + this.model + ", " + this.screenSize + " inch " + (smart ? "smart ":"") + "tv with " + (fourK ? "4K": this.resolution) + " resolution";
    }

    @Override
    public int compareTo(Television o) {
        if (o == null)
            throw new IllegalArgumentException("null parameter in the compareTo method");

        int res = this.make.compareTo(o.make);
        if (res != 0)
            return res;
        res = this.model.compareTo(o.model);
        if (res != 0)
            return res;

        return this.screenSize - o.screenSize;
    }
}
