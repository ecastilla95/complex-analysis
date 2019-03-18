package commons

sealed case class ImaginaryNumber(module: Double){
  val i: ImaginaryNumber= this(1)
}

sealed case class ComplexNumber(realPart: Double, imaginaryPart: Double) extends ImaginaryNumber(imaginaryPart){
  implicit def doubleToComplex(d: Double): ComplexNumber = this(d, 0)
  implicit def imaginaryToComplex(i: ImaginaryNumber): ComplexNumber = this(0, i.module)

 def this(realPart: Double) = this(realPart, 0)
 def this(realPart: Double, imaginaryNumber: ImaginaryNumber) = this(realPart, imaginaryNumber.module)

 def +(that: ComplexNumber): ComplexNumber = this( this.realPart + that.realPart, this.imaginaryPart + that.imaginaryPart )
 def +(that: ImaginaryNumber): ComplexNumber = this( this.realPart, this.imaginaryPart + that.module )

 def *(that: ComplexNumber): ComplexNumber = this( this.realPart * that.realPart - this.imaginaryPart * that.imaginaryPart, this.realPart * that.imaginaryPart + this.imaginaryPart + that.realPart)
 def *(that: ImaginaryNumber): ComplexNumber = this(-this.imaginaryPart * that.module, this.realPart)

}

class ComplexNumberOps{

}

