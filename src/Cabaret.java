import java.util.ArrayList;

public class Cabaret
{
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name)
    {
        this.name = name;
        performers = new ArrayList<Performer>();
    }

    public boolean addPerformer(Performer thisPerformer)
    {
        if (performers.indexOf(thisPerformer) != -1)
        {
            return false;
        }
        else
        {
            performers.add(thisPerformer);
            return true;
        }
    }

    public boolean removePerformer(Performer thisPerformer)
    {
        int index = performers.indexOf(thisPerformer);
        if (index == -1)
        {
            return false;
        }
        else
        {
            performers.remove(index);
            return true;
        }
    }

    public double averagePerformerAge()
    {
        int sum = 0;
        int numPerformers = 0;

        for (Performer thisPerformer : performers)
        {
            sum += thisPerformer.getAge();
            numPerformers++;
        }
        return (double) sum / numPerformers;
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> overAge = new ArrayList<Performer>();
        for (Performer thisPerformer : performers)
        {
            if (thisPerformer.getAge() <= age)
            {
                overAge.add(thisPerformer);
            }
        }
        return overAge;
    }

    public void groupRehearsal()
    {
        for (Performer thisPerformer : performers)
        {
            System.out.println("REHEARSAL CALL!: " + thisPerformer.getName());
            if (thisPerformer instanceof Performer || thisPerformer instanceof Dancer)
            {
                Dancer temp = (Dancer)thisPerformer;
                temp.rehearse();
            }
            if (thisPerformer instanceof Comedian)
            {
                Comedian temp = (Comedian)thisPerformer;
                temp.rehearse(false);
            }
        }
    }

    public void cabaretShow()
    {
        for (Performer thisPerformer : performers)
        {
            System.out.println("Welcome to the cabaret! Next act up... " + thisPerformer.getName());
            if (thisPerformer instanceof Performer || thisPerformer instanceof Comedian)
            {
                Performer temp = (Performer)thisPerformer;
                temp.perform();
            }
            if (thisPerformer instanceof Dancer)
            {
                Dancer temp = (Dancer)thisPerformer;
                temp.pirouette(2);
            }
        }
    }
}
