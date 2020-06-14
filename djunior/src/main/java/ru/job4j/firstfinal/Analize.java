package ru.job4j.firstfinal;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Map<Integer, String> curMap = current.stream().collect(Collectors.toMap(User::getId, User::getName));
        previous.forEach(c-> {
            if (curMap.get(c.getId()) == null) {
                info.incDeleted();
            }
            if (curMap.get(c.getId()) != null && !c.getName().equals(curMap.get(c.getId()))) {
                info.incChanged();
            }
        });
        int diff = current.size() - (previous.size() - info.getDeleted());
        info.setAdded(diff);
        //List<User> diff = current.stream().filter(cur->!previous.contains(cur)).collect(Collectors.toList());
        return info;
    }

    public static class User {
        int id;
        String name;
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "User: {name: " + name + " id: " + id + "}";
        }
        @Override
        public boolean equals(Object anObject) {
            User tmpUser = (User) anObject;
            if (tmpUser.getId() == this.id) {
                return true;
            }

            return false;
        }
        @Override
        public int hashCode() {
            return (int) this.id;
        }
    }

    public static class Info {

        int added = 0;
        int changed = 0;
        int deleted = 0;
        public Info() {

        }
        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
        public int getAdded() {
            return added;
        }
        public int getChanged() {
            return changed;
        }
        public int getDeleted() {
            return deleted;
        }
        public void setAdded(int added) {
            this.added = added;
        }
        public void setChanged(int changed) {
            this.changed = changed;
        }
        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }
        public void incAdded() {
            this.added++;
        }
        public void incChanged() {
            this.changed++;
        }
        public void incDeleted() {
            this.deleted++;
        }
        @Override
        public String toString() {
            return "Info: {added: " + added + " changed: " + changed + " deleted: " + deleted + "}";
        }
        @Override
        public boolean equals(Object tmpObject) {
            Info tmpInfo = (Info) tmpObject;
            if (this.deleted == tmpInfo.deleted && this.changed == tmpInfo.changed && this.added == tmpInfo.added) {
                return true;
            }
            return false;
        }
        @Override
        public int hashCode() {
            return this.deleted * this.changed * this.added;
        }
    }
}
