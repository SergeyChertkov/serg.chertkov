package elements;

/**
 * Created by Sergii_Chertkov on 11/10/2016.
 */
public final class SimpleXPath implements IHaveAnXPath {
    private final String xPath;

    public SimpleXPath(String path) {
        this.xPath = path;
    }

    public String getXPath() {
        return this.xPath;
    }

    public String toString() {
        return this.xPath;
    }

    public int hashCode() {
        byte result = 1;
        int result1 = 31 * result + (this.xPath == null?0:this.xPath.hashCode());
        return result1;
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else if(this.getClass() != obj.getClass()) {
            return false;
        } else {
            IHaveAnXPath other = (IHaveAnXPath)obj;
            if(this.xPath == null) {
                if(other.getXPath() != null) {
                    return false;
                }
            } else if(!this.xPath.equals(other.getXPath())) {
                return false;
            }
            return true;
        }
    }
}