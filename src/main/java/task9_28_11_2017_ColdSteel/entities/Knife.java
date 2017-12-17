package task9_28_11_2017_ColdSteel.entities;


public class Knife {
    public String knifeType;
    public int knifeHandy;
    public String knifeOrigin;
    public Knife.KnifeVisual knifeVisual;
    public boolean collection;
    public String name;

    public String getKnifeType() {
        return knifeType;
    }

    public void setKnifeType(String value) {
        this.knifeType = value;
    }

    public int getKnifeHandy() {
        return knifeHandy;
    }

    public void setKnifeHandy(int value) {
        this.knifeHandy = value;
    }

    public String getKnifeOrigin() {
        return knifeOrigin;
    }

    public void setKnifeOrigin(String value) {
        this.knifeOrigin = value;
    }

    public Knife.KnifeVisual getKnifeVisual() {
        return knifeVisual;
    }

    public void setKnifeVisual(Knife.KnifeVisual value) {
        this.knifeVisual = value;
    }

    public boolean isCollection() {
        return collection;
    }

    public void setCollection(boolean value) {
        this.collection = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public static class KnifeVisual {

        public Knife.KnifeVisual.KnifeBlade knifeBlade;

        public Knife.KnifeVisual.KnifeHandle knifeHandle;

        public Knife.KnifeVisual.KnifeBlade getKnifeBlade() {
            return knifeBlade;
        }

        public void setKnifeBlade(Knife.KnifeVisual.KnifeBlade value) {
            this.knifeBlade = value;
        }

        public Knife.KnifeVisual.KnifeHandle getKnifeHandle() {
            return knifeHandle;
        }

        public void setKnifeHandle(Knife.KnifeVisual.KnifeHandle value) {
            this.knifeHandle = value;
        }

        public static class KnifeBlade {


            protected int length;

            public int width;

            public MetalType metal;

            public int getLength() {
                return length;
            }

            public void setLength(int value) {
                this.length = value;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int value) {
                this.width = value;
            }

            public MetalType getMetal() {
                return metal;
            }

            public void setMetal(MetalType value) {
                this.metal = value;
            }

            @Override
            public String toString() {
                return "KnifeBlade{" +
                        "length=" + length +
                        ", width=" + width +
                        ", metal=" + metal +
                        '}';
            }
        }

        public static class KnifeHandle {

            public Knife.KnifeVisual.KnifeHandle.Wood wood;
            public Object leatherCoated;
            public Object plastic;

            public Knife.KnifeVisual.KnifeHandle.Wood getWood() {
                return wood;
            }

            public void setWood(Knife.KnifeVisual.KnifeHandle.Wood value) {
                this.wood = value;
            }

            public Object getLeatherCoated() {
                return leatherCoated;
            }

            public void setLeatherCoated(Object value) {
                this.leatherCoated = value;
            }

            public Object getPlastic() {
                return plastic;
            }

            public void setPlastic(Object value) {
                this.plastic = value;
            }

            public static class Wood {
                public WoodType type;

                public WoodType getType() {
                    return type;
                }

                public void setType(WoodType value) {
                    this.type = value;
                }

                @Override
                public String toString() {
                    return "Wood{" +
                            "type=" + type +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "KnifeHandle{" +
                        "wood=" + wood +
                        ", leatherCoated=" + leatherCoated +
                        ", plastic=" + plastic +
                        '}';
            }
        }

        @Override
        public String toString() {
            return knifeBlade.toString() + knifeHandle.toString();
        }
    }

    @Override
    public String toString() {
        return "Knife{" +
                "knifeType='" + knifeType + '\'' +
                ", knifeHandy=" + knifeHandy +
                ", knifeOrigin='" + knifeOrigin + '\'' +
                ", knifeVisual=" + knifeVisual +
                ", collection=" + collection +
                ", name='" + name + '\'' +
                '}';
    }
}