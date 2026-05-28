    package com.example.foodorder.service;

    import com.example.foodorder.dto.CartRequest;
    import com.example.foodorder.entity.Cart;
    import com.example.foodorder.entity.CartItem;
    import com.example.foodorder.entity.FoodItem;
    import com.example.foodorder.entity.User;
    import com.example.foodorder.repository.CartItemRepository;
    import com.example.foodorder.repository.CartRepository;
    import com.example.foodorder.repository.FoodItemRepository;
    import com.example.foodorder.repository.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;


    @Service
    public class CartServiceImpl implements CartService {

        @Autowired
        CartItemRepository cartItemRepository;

        @Autowired
        CartRepository cartRepository;

        @Autowired
        UserRepository userRepository;

        @Autowired
        FoodItemRepository foodItemRepository;

        public CartItem addToCart(CartRequest cartRequest){

             User user = userRepository.findById(cartRequest.getUserId())
                     .orElseThrow(() -> new RuntimeException("User not found"));

             FoodItem foodItem = foodItemRepository.findById(cartRequest.getFoodItemId())
                     .orElseThrow(() -> new RuntimeException("fooditem not found"));

             Cart cart = cartRepository.findByUser(user);
             if(cart == null){
                 cart = new Cart();
                 cart.setUser(user);
                 cart = cartRepository.save(cart);
             }

             CartItem cartItem= new CartItem();
             cartItem.setCart(cart);
             cartItem.setFoodItem(foodItem);
             cartItem.setQuantity(cartRequest.getQuantity());

             return cartItemRepository.save(cartItem);

        }
        @Override
        public List<CartItem> getCartByUser(int userId){

            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));


            Cart cart = cartRepository.findByUser(user);


            if(cart == null){
                return List.of();
            }


            return cartItemRepository.findByCart(cart);
        }

        public void removeCartItem(int cartItemId){
           CartItem cartItem= cartItemRepository.findById(cartItemId)
                   .orElseThrow(() -> new RuntimeException("cartItem not Found"));
            cartItemRepository.deleteById(cartItemId) ;
        }

        @Override
        public CartItem updateCartItem(int cartItemId, int quantity) {
            CartItem cartItem= cartItemRepository.findById(cartItemId).orElseThrow(() -> new RuntimeException("cartitem not found"));
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
            return cartItem;
        }

    }



