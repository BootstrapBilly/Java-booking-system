//package Data.Managers.Appointments;
//
//import Constants.LessonTypes;
//import Models.Event.Appointment;
//import Models.Lesson.Lesson;
//import Models.Util.Classes.Entity;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//
//public class AppointmentsManager {
//
//    private ArrayList<Appointment> appointments;
//    private ArrayList<Appointment> appointmentsToDisplay;
//
//    private String currentLessonType = "";
//    private ArrayList<Entity> lessonTypes = new ArrayList<Entity>(
//            Arrays.asList(new Entity(LessonTypes.FOOTBALL), new Entity(LessonTypes.BASKETBALL), new Entity(LessonTypes.BADMINTON),
//                    new Entity(LessonTypes.GYMNASTICS), new Entity(LessonTypes.CRICKET), new Entity(LessonTypes.SWIMMING))
//    );
//
//    public AppointmentsManager() {
//        lessons = new ArrayList<Lesson>();
//        lessonsToDisplay = new ArrayList<Lesson>();
//    }
//
//    public void bookLesson(String id){
//        for(Lesson l : lessons){
//            if(l.getID() == id){
//                l.incrementCapacity();
//            }
//        }
//    }
//
//    public void cancelLesson(String id) {
//        for(Lesson l : lessons){
//            if(l.getID() == id){
//                l.decrementCapacity();
//            }
//        }
//    }
//
//    public void addLessons(Lesson[] lessons){
//        this.lessons.addAll(Arrays.asList(lessons));
//    }
//
//
//    public void setLessonsToDisplay(Lesson[] lessons){
//        lessonsToDisplay = new ArrayList<>(Arrays.asList(lessons));
//    }
//
//    public void setLessonsToDisplayByType(){
//        ArrayList lessonsToDisplay = new ArrayList();
//        Iterator<Lesson> lessonsIterator = this.lessons.iterator();
//        while(lessonsIterator.hasNext()){
//            Lesson next = lessonsIterator.next();
//            if(next.getName() == currentLessonType){
//                lessonsToDisplay.add(next);
//            }
//        }
//        this.lessonsToDisplay = lessonsToDisplay;
//
//    }
//
//    public Lesson getLessonById(String ID){
//        Iterator<Lesson> lessonsIterator = this.lessons.iterator();
//        while(lessonsIterator.hasNext()){
//            Lesson next = lessonsIterator.next();
//            if(next.getID() == ID){
//                return next;
//            }
//        }
//
//        return null;
//    }
//
//    public ArrayList<Entity> getLessonTypes(){
//        return lessonTypes;
//    }
//
//    public void setCurrentLessonType(String typeId){
//        Iterator<Entity> typesIterator = this.lessonTypes.iterator();
//        while(typesIterator.hasNext()){
//            Entity next = typesIterator.next();
//            if(next.getID() == typeId){
//               this.currentLessonType = next.getName();
//            }
//        }
//    }
//
//    public String getCurrentLessonType() {
//        return currentLessonType;
//    }
//
//    public ArrayList<Lesson> getLessonsToDisplay() {
//        return lessonsToDisplay;
//    }
//
//}
