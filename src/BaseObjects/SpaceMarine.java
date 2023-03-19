package BaseObjects;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

public class SpaceMarine implements Comparable<SpaceMarine>{
    private Long id; //�������� ����� ���� ������ ���� ����������
    private String name;
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    private float health;
    private AstartesCategory category; //���� �� ����� ���� null
    private Weapon weaponType; //���� ����� ���� null
    private MeleeWeapon meleeWeapon; //���� �� ����� ���� null
    private Chapter chapter; //���� ����� ���� null

    public SpaceMarine(String name, Coordinates coordinates, float health, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDateTime.now();
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public SpaceMarine(Long id, String name, Coordinates coordinates, ZonedDateTime creationDate, float health, AstartesCategory category, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.category = category;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.time.ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public AstartesCategory getCategory() {
        return category;
    }

    public void setCategory(AstartesCategory category) {
        this.category = category;
    }

    public Weapon getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(Weapon weaponType) {
        this.weaponType = weaponType;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
        this.meleeWeapon = meleeWeapon;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    @Override
    public int compareTo(SpaceMarine o) {
        /*if (this.health - o.health > 0) {
            return 1;
        }
        else if (this.health - o.health < 0) {
            return -1;
        }
        else {
            return 0;
        }*/
        // ��������� �� id ��� ��� ���� ��� ������������ ��������� �� ������������ ��� TreeSet
        if (this.id - o.id > 0) {
            return 1;
        }
        else if (this.id - o.id < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public boolean validateID() {
        if (this.getId() != null) {
            if (0 <= this.getId() || this.getId() < Long.MAX_VALUE) {
                return true;
            }
            else {
                System.out.println("ID ������ ���� �������������, � �������� ������� Long");
                return false;
            }
        }
        else {
            System.out.println("ID ������ ���� ��������� ������ ���� Long.");
            return false;
        }
    }

    public boolean validateName() {
        if (this.getName() != null) {
            if (!Objects.equals(this.getName(), "")) {
                return true;
            }
            else {
                System.out.println("��� �� ������ ���� ������");
                return false;
            }
        }
        else {
            System.out.println("��� �� ������ ���� null");
            return false;
        }
    }

    public boolean validateCoordinates() {
        if (this.getCoordinates() != null) {
            if (this.getCoordinates().getX() != null) {
                return true;
            }
            else {
                System.out.println("���������� X �� ����� ���� null");
                return false;
            }
        }
        else {
            System.out.println("���������� �� ����� ���� null");
            return false;
        }
    }

    public boolean validateCreationDate() {
        if (this.getCreationDate() != null) {
            return true;
        }
        else {
            System.out.println("���� �������� �� ����� ���� null");
            return false;
        }
    }

    public boolean validateHealth() {
        if (this.getHealth() > 0) {
            return true;
        }
        else {
            System.out.println("���������� �������� ������ ���� ������ 0");
            return false;
        }
    }

    public boolean validateCategory() {
        if (this.getCategory() != null) {
            return true;
        }
        else {
            System.out.println("��������� �� ����� ���� null");
            return false;
        }
    }

    public boolean validateMeleeWeapon() {
        if (this.getMeleeWeapon() != null) {
            return true;
        }
        else {
            System.out.println("������� ������ �� ����� ���� null");
            return false;
        }
    }
}

