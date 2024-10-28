package es.uco.practica1;
import es.uco.practica1.Enums;

public class Material 
{
    /**
     * El identificador único del material.
     */
    private int id;
    
    /**
     * El tipo de material, que puede ser de varios tipos definidos en {@link Enums.tipo}.
     */
    private Enums.tipo type;
    
    /**
     * El estado del material, que indica si está disponible, en uso, etc.
     */
    private Enums.estado status;
    
    /**
     * Indica si el material es para uso en interiores (true) o exteriores (false).
     */
    private boolean usoMaterial; // true = interior, false = exterior
    

    /**
     * Constructor que inicializa el material con un identificador, tipo, uso (interior o exterior)
     * y estado.
     * 
     * @param id El identificador del material.
     * @param type El tipo de material, de tipo {@link Enums.tipo}.
     * @param usoMaterial Indica si el material es para interiores (code true) o exteriores (code false).
     * @param status El estado del material, de tipo {@link Enums.estado}.
     */
    public Material(int id, Enums.tipo type, boolean usoMaterial, Enums.estado status)
    {
        this.id = id;
        this.type = type;
        this.usoMaterial = usoMaterial;
        this.status = status;
    }
    
    /**
     * Constructor por defecto que inicializa un material con valores predeterminados.
     * El id será 0, el uso será para interiores, y el tipo y estado serán indefinidos.
     */
    public Material()
    {
        this.id = 0;
        this.usoMaterial = true;
        this.type = Enums.tipo.NONE;
        this.status = Enums.estado.NONE;
    }
    
    /**
     * Devuelve el identificador del material.
     * 
     * @return El identificador del material.
     */
    public int getId()
    {
        return this.id;
    }
    
    /**
     * Establece el id del material
     * 
     * @param id El identificador del material.
     * */
    public void setId(int id)
    {
    	this.id = id;
    }
    
    /**
     * Devuelve el tipo de material.
     * 
     * @return El tipo de material, de tipo {@link Enums.tipo}.
     */
    public Enums.tipo getType()
    {
        return this.type;
    }
    
    /**
     * Establece el tipo del material
     * 
     * @param type El tipo de material.
     * */
    public void setType(Enums.tipo type)
    {
    	this.type = type;
    }
    
    /**
     * Devuelve el estado del material.
     * 
     * @return El estado del material, de tipo {@link Enums.estado}.
     */
    public Enums.estado getStatus()
    {
        return this.status;
    }
    
    /**
     * Establece el estado del material
     * 
     * @param status El estado del material.
     * */
    public void setStatus(Enums.estado status)
    {
    	this.status = status;
    }
    
    /**
     * Devuelve el uso del material, indicando si es para interiores o exteriores.
     * 
     * @return true si el material es para interiores, false si es para exteriores.
     */
    public boolean getMaterialUse()
    {
        return this.usoMaterial;
    }
    
    /**
     * Establece el uso del material (true para interiores y false para exteriores)
     * 
     * @param uso El uso del material.
     * */
    public void setMaterialUse(boolean uso)
    {
    	this.usoMaterial = uso;
    }
    
    /**
     * Devuelve una representación en cadena de los atributos del material.
     * 
     * @return Una cadena que describe el material con su id, tipo, estado y uso.
     */
    @Override
    public String toString()
    {
        return "Id: " + this.id + " Tipo: " + this.type
                + " Estado: " + this.status + " Uso Material: " + this.usoMaterial;
    }
}

