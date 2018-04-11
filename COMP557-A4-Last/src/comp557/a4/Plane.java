package comp557.a4;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

/**
 * Class for a plane at y=0.
 * 
 * This surface can have two materials.  If both are defined, a 1x1 tile checker 
 * board pattern should be generated on the plane using the two materials.
 */
public class Plane extends Intersectable {

	/** The second material, if non-null is used to produce a checker board pattern. */
	Material material2;

	/** The plane normal is the y direction */
	public static final Vector3d n = new Vector3d( 0, 1, 0 );

	/**
	 * Default constructor
	 */
	public Plane() {
		super();
	}


	@Override
	public void intersect( Ray ray, IntersectResult result ) {

		// TODO: Objective 4: finish this class   
		double t = -ray.eyePoint.y / ray.viewDirection.y;
		if(t > 1e-9 && t < result.t){
			result.t = t;
			result.n.set(Plane.n);
			result.p.scaleAdd(t, ray.viewDirection, ray.eyePoint);
			Point3d intersection = new Point3d(result.p);
			intersection.x = (intersection.x % 2 + 2) % 2;
			intersection.z = (intersection.z % 2 + 2) % 2;
			if( this.material2 == null){
				result.material = this.material;
			}else if((intersection.x >= 1 && intersection.z >= 1) || (intersection.x < 1 && intersection.z < 1)){
				result.material = this.material;
			}else{
				result.material = this.material2;
			}
		}
	}

}
