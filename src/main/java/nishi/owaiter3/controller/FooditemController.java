package nishi.owaiter3.controller;
import nishi.owaiter3.entity.Fooditem;
import nishi.owaiter3.repository.FooditemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RequestMapping("/items")
public class FooditemController {

    private static String UPLOAD_DIR="C:\\owaiter3\\src\\main\\imagerepo\\uploads\\";

    @Autowired
    private FooditemRepository irepo;

    @PostMapping(value = "/upload")
    public  ResponseEntity<Object>uploadFile(@RequestParam("file") MultipartFile file) throws IOException
    {
        File convertfile=new File(UPLOAD_DIR + file.getOriginalFilename());
        convertfile.createNewFile();
        FileOutputStream fout=new FileOutputStream(convertfile);
        fout.write(file.getBytes());
        fout.close();

        return new ResponseEntity<>("file succesfully uploaded",HttpStatus.OK);
    }


   /*@GetMapping("/getimages")
    @CrossOrigin
    public ResponseEntity<List<String>> getImages()
    {


        List<String> images=new ArrayList<String>();
        String filepath =context.getRealPath("src/main/imagerepo");
        File filefolder=new File(filepath);
        if(filefolder!=null)
        {
            for(final File file:filefolder.listFiles())
            {
                if(!file.isDirectory())
                {
                    String encodeBase64=null;
                    try {
                            String extension= FileNameMap.getExtension(file.getName());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                }
            }
        }
    }
*/
    @GetMapping(value = "/all")
    public List<Fooditem> getItems()
    { return irepo.findAll();}

    @GetMapping("/item/{id}")
    public Optional<Fooditem> getItem(@PathVariable int id )
    { return irepo.findById(id);}


    private Fooditem getItemById(int itemno)
    {
        Fooditem obj = irepo.findById(itemno).get();
        return obj;
    }
    @DeleteMapping("/item/{itemno}")
    public ResponseEntity<Void> deleteTable(@PathVariable("itemno") int item)
    {
        irepo.delete(getItemById(item));
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/item")
    public  Fooditem addItem1(@RequestBody Fooditem item)
    {
        return irepo.save(item);
    }

    @PutMapping("/item")
    public  Fooditem editItem(@RequestBody Fooditem item)
    {
        return irepo.save(item);
    }


    //food types
    @GetMapping("/type/meal/{itemtype}")
    public List<Fooditem> findByItemtypeMeal(@PathVariable String itemtype)
    {
        return irepo.findByItemtype("meal");

    }
    @GetMapping("/type/beverage/{itemtype}")
    public List<Fooditem> findByItemtypeBeverage(@PathVariable String itemtype)
    {
        return irepo.findByItemtype("beverage");
    }
    @GetMapping("/type/dessert/{itemtype}")
    public List<Fooditem> findByItemtypeDessert(@PathVariable String itemtype)
    {
        return irepo.findByItemtype("dessert");

    }





}
