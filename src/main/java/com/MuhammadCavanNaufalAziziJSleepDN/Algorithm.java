package com.MuhammadCavanNaufalAziziJSleepDN;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

/**
 * This class contains a collection of methods for working with Iterators, Iterables, and arrays.
 * The methods allow for filtering, counting, and collecting elements that match a given condition.
 */
public class Algorithm{
    /**
     * Private constructor to prevent instantiation of this class.
     * All methods in this class are static and should be called directly.
     */
    private Algorithm(){}

    public static <T> List<T> collect(Iterable<T> iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred)
    {
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(T[] array, T value)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, value);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value)
    {
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred)
    {
        List<T> list = new ArrayList<>();
        while (iterator.hasNext())
        {
            T current = iterator.next();
            if (pred.predicate(current))
                list.add(current);
        }
        return list;
    }

    public static <T> int count(Iterator<T> iterator, T value)
    {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] array, T value)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred)
    {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public static <T> int count(T[] array, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred)
    {
        int count = 0;
        while (iterator.hasNext())
        {
            T current = iterator.next();
            if (pred.predicate(current))
                count++;
        }
        return count;
    }

    public static <T> int count(Iterable<T> iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred)
    {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    public static <T> boolean exists(T[] array, T value)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value)
    {
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred)
    {
        while (iterator.hasNext())
        {
            T current = iterator.next();
            if(pred.predicate(current))
                return true;
        }
        return false;
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, pred);
    }
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }
    public static <T> T find(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, value);
    }
    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }
    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T tmp = iterator.next();
            if (pred.predicate(tmp))
                return tmp;
        }
        return null;
    }

    public static <T> List<T> Paginate(T[] array, int page, int pageSize, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return Paginate(it, page, pageSize, pred);
    }

    public static <T> List<T> Paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred)
    {
        int occurences = 0;
        int startingIdx = page * pageSize;
        List<T> pageList = new ArrayList<>(pageSize);
        while (iterator.hasNext() && occurences < startingIdx) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                ++occurences;
        }
        while (iterator.hasNext() && pageList.size() < pageSize) {
            T obj = iterator.next();
            if (pred.predicate(obj))
                pageList.add(obj);
        }
        return pageList;
    }

    public static <T> List<T> Paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred)
    {
        final Iterator<T> it = iterable.iterator();
        return Paginate(it, page, pageSize, pred);
    }

    public static String getMd5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

