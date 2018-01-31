# SharePrefrenceToyApp
simple demo of Shared Prefrence
- In shared prefrence data is stored in a xml file inside the app folder.
- data is stored in a key value pair.
- key is String type while value is of primitive datatype.
- data types are only primitive data type only.
- read and write using primitive data type only.
- once the data is saved it remains saved even app is closed and restarted and if phone is restarted.

## Code description
        SharedPreferences sharedPreferences = getSharedPreferences("name of the file", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit(); 
- now in first line of code  getSharedPreferences("name of the file", MODE_PRIVATE) will create a file inside app folder and will keep     it private i.e no other app will be able to access it. after creating a file it will return a SharedPrefrence object that represents     this file.

- in second line of code sharedPreference.edit() will return an Editor object that has methods to facilitate writing data 
  to the xml(Shared Prefrence) file.

### Writing to Shared Prefrence file
        SharedPreferences sharedPreferences = getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("color", color);
        editor.apply();

- Now in line 4 "color" is the key name and color is integer.
- editor.apply() will save the changes we made to shared prefrence file.
#### OR
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
 - the above line will get a sharedPrefrence object that represents the default shared Prefrence file of the App.
                
      
### Reading from Shared Prefrence file
        int selectedColor = sharedPreferences.getInt("color",someDefaultIntValue);
        
 - so in above line we want to get the Int value stored against key "color" ,and if their was no key by name "color" than the int value
   in second parameter will be returned to avoid crash.

### Listen for changes in shared Preference file.
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        
 - we can also listen to the changes made in shared preference file.
 - the above code will register MainActivity as a listener class for any change in shared preference file.
 - offcourse we would than have to implement some listener methods inside our listener class which in our case is MainActivity.
