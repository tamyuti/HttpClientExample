package pojoGet;

public class Company {
	  private String catchPhrase;

	    private String name;

	    private String bs;

	    public String getCatchPhrase ()
	    {
	        return catchPhrase;
	    }

	    public void setCatchPhrase (String catchPhrase)
	    {
	        this.catchPhrase = catchPhrase;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public String getBs ()
	    {
	        return bs;
	    }

	    public void setBs (String bs)
	    {
	        this.bs = bs;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [catchPhrase = "+catchPhrase+", name = "+name+", bs = "+bs+"]";
	    }

}
