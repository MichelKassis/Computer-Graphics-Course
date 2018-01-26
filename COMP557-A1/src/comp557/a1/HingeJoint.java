package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class HingeJoint extends DAGNode {

	DoubleParameter rx;
	DoubleParameter ry;
	DoubleParameter rz;
	
	double xAxis;
	double yAxis;
	double zAxis;
	
	double tx;
	double ty;
	double tz;
	
	
	
	public HingeJoint(String name, double minAngle, double maxAngle,
			double xAxis, double yAxis, double zAxis,
			double tx, double ty, double tz
			) {
		super(name);
		
		dofs.add( rx = new DoubleParameter( name+" rx", 0, minAngle, maxAngle ) );		
		dofs.add( ry = new DoubleParameter( name+" ry", 0, minAngle, maxAngle ) );
		dofs.add( rz = new DoubleParameter( name+" rz", 0, minAngle, maxAngle ) );
		
		
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glPushMatrix();
		
		gl.glTranslated(tx, ty -1, tz);
		
		if(xAxis != 0 ) {
		gl.glRotated(rx.getValue(), 1, 0, 0);}
		if(yAxis != 0 ) {
		gl.glRotated(ry.getValue(), 0, 1, 0);}
		if(zAxis != 0 ) {
		gl.glRotated(rz.getValue(), 0, 0, 1);}
		
		super.display(drawable);
		
		gl.glPopMatrix();
	
	}
	
}
