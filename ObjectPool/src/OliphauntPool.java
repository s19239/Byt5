import com.sun.org.apache.xml.internal.utils.ObjectPool;

public class OliphauntPool extends ObjPool<Oliphaunt> {




        @Override
        protected Oliphaunt create() {
            return new Oliphaunt();
        }

}