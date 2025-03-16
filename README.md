# Meal_Prep

## About

Using my SpringBoot template this is an app intended to help you prepare your weekly meals. 

Inteded Functionality:
  - Recipe book
  - Weekly meals planning
  - Weekly shop list generator

## Technology Stack

This project is built using the following technologies:

- **Frontend:** Nothing implemented yet...
- **Backend:** Java, SpringBoot
- **Database:** PostgreSQL, Spring Data JPA
- **DevOps & Deployment:** Not yet implemented
- **Other:** 

## SpringBoot Annotations Utilised

A place to document all the annotations utilised - including any 
information relevant that is good to remember.

First one as this caused me grief...

### @GetMapping
`@GetMapping` is one of the five specified annotations for each HTTP request type.

1. `@GetMapping`
2. `@PostMapping`
3. `@PutMapping`
4. `@DeleteMapping`
5. `@PatchMapping`

As I have come to find out trying to implement a new method to get the ingredients
for a given recipe. `@GetMapping` annotated methods is used to handle HTTP GET requests
which can be paired with a given URI expression.

Initially, from the SpringBoot template we created the below which is automatically called
if annotations are not added:

    @GetMapping()
        public List<Recipe> getrecipes() {
            return recipeService.getRecipes();
        }

What we've implemented below is the `@GetMapping` containing the annotations to map the
functionality to the method we created to retrieve the ingredients for a given recipe ID:

    @GetMapping("/getRecipe/{recipeId}")
        public List<String> getIngredients(@PathVariable Long recipeId) {
            return recipeService.getIngredients(recipeId); 
        }

## Installation

Provide instructions on how to install and run the project locally.

```bash
# Clone the repository
git clone https://github.com/

```
